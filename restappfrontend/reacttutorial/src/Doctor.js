import { useLocation } from "react-router";
import { DoctorDetailList } from "./DoctorDetailList";

function Doctor() {
    const location = useLocation();

    return (
        <div className="hooked-data">
            {JSON.stringify(location.state)}

            <DoctorDetailList />
        </div>
    )
}

export default Doctor;
