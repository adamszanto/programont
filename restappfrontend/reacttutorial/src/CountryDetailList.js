import React, { useEffect, useState } from "react";
import { useLocation, useParams } from "react-router-dom";
import {Footer} from "./Footer";
import BackTo from "./BackTo";
import CountryCard from "./CountryCard";
import {CountryCardHeader} from "./CountryCardHeader";

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

    return (
        <div className="main-div">
            <CountryCardHeader />
            <CountryCard
                key={country.id}
                countryId={country.id}
                name={country.name}
                cities={country.cities}
            />
            <BackTo />
            <Footer />
        </div>
    );
}