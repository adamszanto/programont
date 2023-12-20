import React from "react";
import './index.css';
export function PatientHeader() {
    return(
        <div className="patientTableHeader">
            <div className="tableRowHeader">
                <div className="tableCell">Patient Id</div>
                <div className="tableCell">Patient Name</div>
                <div className="tableCell">Date of birth</div>
            </div>
        </div>
    )
}