import { useLocation } from "react-router";
import { CountryDetailList } from "./CountryDetailList";

function Country() {
    const location = useLocation();

    return (
        <div className="hooked-data">
            {/*{JSON.stringify(location.state)}*/}

            <CountryDetailList />
        </div>
    )
}

export default Country;
