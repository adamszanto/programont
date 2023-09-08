import React, { useEffect, useState } from "react";

export default function CountryCard({ countryId, name, cities }) {
    return(
        <div className="countryCard">
            <div className="countryCardLeft">
                <div className="countryCardItem">
                    <span className="label">Country ID: </span>
                    <span className="value">{countryId}</span>
                </div>
                <div className="countryCardItem">
                    <span className="label">Name: </span>
                    <span className="value">{name}</span>
                </div>
                <div className="countryCardItem">
                    <span className="label">Cities: </span>
                    <span className="value">
                        {cities && cities.length > 0
                            ? cities.map((city) => city.name).join(", ")
                            : "No cities available"}
                    </span>
                </div>
            </div>
        </div>
    )
}