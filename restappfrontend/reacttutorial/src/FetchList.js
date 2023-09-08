import {DisplayHeader} from "./DisplayHeader";
import Display from "./Display";
import React, {useEffect, useState} from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export function FetchList() {
    const [countries, setCountries] = useState([]);
    const navigate = useNavigate();
    const { countryId } = useParams();

    useEffect(()=> {
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/cc/all");
                if(!response.ok) {
                    throw new Error("Couldn't process request");
                }
                const data = await response.json();
                setCountries(data);
            } catch (error) {
                console.error("Error happened", error);
            }
        };
        fetchData();
    }, []);

    const handleRemoveCountry = (countryIdToRemove) => {
        // Send a DELETE request to remove the country with the specified ID
        fetch(`http://localhost:8080/api/cc/country/${countryIdToRemove}`, {
            method: "DELETE",
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Couldn't delete country");
                }
                // Update the list of countries in your state after successful deletion
                setCountries((prevCountries) =>
                    prevCountries.filter((country) => country.id !== countryIdToRemove)
                );
            })
            .catch((error) => {
                console.error("Error deleting country", error);
            });
    };

    const handleViewCountry = (countryId) => {
        navigate("/country/${countryId}", {
            state: { countryId }
        });

    };

    console.log("FetchList.js countryId: " + countryId);
    console.log("FetchList.js country.id: " + countries.id);
    return(
        <div className="countryList">
            <DisplayHeader />
            {countries.map((country) => (
                <Display
                    key={country.id}
                    countryId={country.id}
                    name={country.name}
                    cityNum={country.cities.length}
                    onView={handleViewCountry}
                    onDelete={handleRemoveCountry}
                />
            ))}
        </div>
    );
}
