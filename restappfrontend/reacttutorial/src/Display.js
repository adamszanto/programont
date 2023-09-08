import React from "react"
import { useState } from "react"

import { Link } from "react-router-dom";
import {DisplayTemplate} from "./DisplayTemplate";


export default function Display({ countryId, name, cities, cityNum, onDelete, onView }) {
    const [data, setData] = useState([]);
    const handleRemoveClick = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/cc/country/${countryId}`, {
                method: "DELETE",
            });

            if (!response.ok) {
                throw new Error("Couldn't delete country");
            }

            const updatedData = data.filter(item => item.countryId !== countryId);
            setData(updatedData);

            onDelete(countryId);
        } catch (error) {
            console.error("Error deleting country", error);
        }
    };

    return (
                <DisplayTemplate
                    countryId={countryId}
                    name={name}
                    cityNum={cityNum}
                    onView={onView}
                    onDelete={handleRemoveClick}
                />
    )
}