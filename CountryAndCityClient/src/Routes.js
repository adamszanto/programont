import {
    Routes,
    Route
} from "react-router";

import App from "./App";
import Country from "./Country";


function ReactRoutes() {
    return (
        <Routes>
            <Route
                path={"/"}
                element={<App />} />
            <Route
                path={"/country/:countryId"}
                element={<Country />} />
        </Routes>
    )
}

export default ReactRoutes;
