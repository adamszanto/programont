import React from "react";
import './index.css';
export function Contactheader() {
    return(
        <div>
            <h2>Happy Patient CRM</h2>
            <hr/>
            <h3>Select Doctor</h3>
            <div className="tableRow">
                <div className="tableCell">Id</div>
                <div className="tableCell">Name</div>
                <div className="tableCell">Specialization</div>
                <div className="tableCell">No. of patients</div>
            </div>
        </div>
    )
}