import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './contact.css'
import Contact from './contact';
import {Doctorlist} from "./doctorlist";
import {Footer} from "./footer";

function App() {

    return (
        <div className="main-div">
            <Doctorlist />
            <Footer />
        </div>
    )
}

ReactDOM.render(<App />, document.getElementById("root"));

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//     temporaryName
// );

