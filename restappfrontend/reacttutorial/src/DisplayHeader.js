import React from "react";
import './style/index.css';
export function DisplayHeader() {
    return(
        <div>
            <h2>Country x City</h2>
            <hr/>
            <div className="tableRowHeader">
                <div className="tableCell"><strong>Id</strong></div>
                <div className="tableCell"><strong>Name</strong></div>
                <div className="tableCell"><strong>No. of cities</strong></div>
                <div className="tableCell"><strong></strong></div>
                <div className="tableCell"><strong></strong></div>
            </div>
        </div>
    )
}