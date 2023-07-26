import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './contact.css'
import Contact from './Contact';
import { DoctorList } from "./DoctorList";
import { Footer } from "./Footer";


function App() {

    return (
        <div className="container">
            <div className="main-div">
                <DoctorList />
                <Footer />
            </div>
        </div>
    )
}

export default App;

