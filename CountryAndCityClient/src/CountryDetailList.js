import React, { useEffect, useState } from "react";
import { useLocation, useParams } from "react-router-dom";
import {Footer} from "./Footer";
import BackTo from "./BackTo";
import CountryCard from "./CountryCard";
import {CountryCardHeader} from "./CountryCardHeader";
import {CityHeader} from "./CityHeader";
import CityDisplay from "./CityDisplay";
import CityAddForm from "./addForm/CityAddForm";

export function CountryDetailList() {
    const params = useParams();
    const location = useLocation();
    const [country, setCountry] = useState({ cities: [] });


    useEffect(() => {
        console.log('Country id: ', location.state.countryId);
        console.log('Params: ', params);

        const countryId = location?.state?.countryId;


        const fetchData = async () => {
            try {
                  const response = await fetch(`http://localhost:8080/api/cc/country/${location.state.countryId}`);
                  console.log(response);
                if (!response.ok) {
                    throw new Error("Couldn't process request");
                }
                const data = await response.json();
                
                setCountry(data);
            } catch (error) {
                console.error("Error happened", error);
            }
        };
        fetchData();
    }, []);

    const handleRemoveCity = (cityIdToRemove) => {
        fetch(`http://localhost:8080/api/cc/city/${cityIdToRemove}`, {
            method: "DELETE",
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Couldn't delete city");
                }
                setCountry((prevCountry) => ({
                    ...prevCountry,
                    cities: prevCountry.cities.filter((city) => city.id !== cityIdToRemove),
                }));
            })
            .catch((error) => {
                console.error("Error deleting city", error);
            });
    };

    const handleCityAdd = async (newCityName) => {
        try {
            const response = await fetch(`http://localhost:8080/api/cc/${country.id}/city`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ name: newCityName }),
            });

            if (!response.ok) {
                throw new Error("Couldn't add city");
            }

            // Frissítsd az állapotot a hozzáadott városokkal
            const data = await response.json();
            setCountry((prevCountry) => ({
                ...prevCountry,
                cities: [...prevCountry.cities, data], // Hozzáadott város
            }));
        } catch (error) {
            console.error("Error adding city", error);
        }
    };

    const handleCityEdit = async (cityId, editedName) => {
        try {
            const response = await fetch(`http://localhost:8080/api/cc/city/${cityId}`, {
                method: "PATCH",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ name: editedName }),
            });

            if (!response.ok) {
                throw new Error("Couldn't edit city");
            }

            // Frissítsd az állapotot az új város névvel
            setCountry((prevCountry) => ({
                ...prevCountry,
                cities: prevCountry.cities.map((city) =>
                    city.id === cityId ? { ...city, name: editedName } : city
                ),
            }));
        } catch (error) {
            console.error("Error editing city", error);
        }
    };


    return (
        <div>
        <div className="main-div">
            <CountryCardHeader />
            <CountryCard
                key={country.id}
                countryId={country.id}
                name={country.name}
                cities={country.cities}
            />
            <div className="cityList">
                    <CityHeader />
                    {country.cities.map((city) => (
                        <CityDisplay key={city.id} id={city.id} name={city.name} onCityEdit={handleCityEdit} />
                    ))}
                    <CityAddForm className="countryInput" onCityAdd={handleCityAdd} />
                    </div>
            <BackTo />
            <Footer />
        </div>
        </div>
    );

    // return (
    //     <div className="main-div">
    //         <CountryCardHeader />
    //         <CountryCard
    //             key={country.id}
    //             countryId={country.id}
    //             name={country.name}
    //             cities={country.cities}
    //         />
    //         <BackTo />
    //         <Footer />
    //     </div>
    // );
}