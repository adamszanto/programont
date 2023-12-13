import React from "react"
import { useState } from "react"

import { Link } from "react-router-dom";
import {DisplayTemplate} from "./DisplayTemplate";
import CountryAddForm from "./addForm/CountryAddForm";


export default function Display({ countryId, name, cities, cityNum, onDelete, onView }) {
    const [data, setData] = useState([]);

    return (
        <div>
                <DisplayTemplate
                    countryId={countryId}
                    name={name}
                    cityNum={cityNum}
                    onView={onView}
                    onDelete={onDelete}
                />
        </div>
    )
}