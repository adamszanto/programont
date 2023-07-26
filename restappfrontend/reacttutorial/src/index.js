import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './contact.css'
import Contact from './Contact';
import { DoctorList } from "./DoctorList";
import { Footer } from "./Footer";

import { BrowserRouter } from 'react-router-dom';
import ReactRoutes from './Routes';

function App() {

    return (
        <BrowserRouter>
            <ReactRoutes />
        </BrowserRouter>
    )
}

ReactDOM.render(<App />, document.getElementById("root"));

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//     temporaryName
// );

