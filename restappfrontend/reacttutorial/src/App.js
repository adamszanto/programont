import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './contact.css'
import Contact from './contact';
import { Doctorlist } from "./doctorlist";
import { Footer } from "./footer";


function App() {

    return (
        <div className="container">
            <div className="main-div">
                <Doctorlist />
                <Footer />
            </div>
        </div>
    )
}

export default App;

