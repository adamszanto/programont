import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './display.css'
import Display from './Display';
import { FetchList } from "./FetchList";
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

