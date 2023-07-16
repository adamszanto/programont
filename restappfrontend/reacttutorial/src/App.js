import React from 'react';
import { Routes, Route } from 'react-router-dom';
import { Doctorlist } from "./doctorlist";
import { DoctorDetailList } from "./DoctorDetailList";
import {Footer} from "./footer";

function App() {
    return (
        <div className="container">
            <div className="main-div">
                <Routes>
                    <Route exact path="/" element={<Doctorlist />} />
                    <Route path="/doctors/:doctorId" element={<DoctorDetailList />} />
                </Routes>
                <Footer />
            </div>
        </div>
    );
}

export default App;
