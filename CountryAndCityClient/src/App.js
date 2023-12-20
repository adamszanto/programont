import React from 'react';
import './index.css';
import './display.css'
import { FetchList } from "./FetchList";
import { Footer } from "./Footer";


function App() {

    return (
        <div className="container">
            <div className="main-div">
                <FetchList />
                <Footer />
            </div>
        </div>
    )
}

export default App;

