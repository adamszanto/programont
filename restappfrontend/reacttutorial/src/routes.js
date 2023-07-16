import {
    Routes,
    Route
} from "react-router";

import App from "./app";
import Doctor from "./Doctor";


function ReactRoutes() {
    return (
        <Routes>
            <Route
                path={`/`}
                element={<App />} />
            <Route
                path={`/doctor/:doctorId`}
                element={<Doctor />} />
        </Routes>
    )
}

export default ReactRoutes;
