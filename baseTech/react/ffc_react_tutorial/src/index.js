import React from 'react';
import ReactDOM from 'react-dom';

function App() {
    const firstName = "Joe";
    const lastName = "Doe";

    return (
            <h1>Hello {firstName} {lastName}</h1>
    )
}

ReactDOM.render(<App />, document.getElementById("root"));




// https://youtu.be/bMknfKXIFA8?t=10858