import React from "react";
import './index.css';
export function Contactheader() {
    return(
        <div>
            <h2>Happy Patient CRM</h2>
            <hr/>
            <h3>Select Doctor for patient list</h3>
            <div className="tableRowHeader">
                <div className="tableCell"><strong>Id</strong></div>
                <div className="tableCell"><strong>Name</strong></div>
                <div className="tableCell"><strong>Specialization</strong></div>
                <div className="tableCell"><strong>No. of patients</strong></div>
            </div>
        </div>
    )
}