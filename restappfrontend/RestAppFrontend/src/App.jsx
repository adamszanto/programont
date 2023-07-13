import React, { useState } from 'react';
import DoctorTable from './DoctorTable.jsx';
import DoctorDetails from './DoctorDetails.jsx';


const App = () => {
    const [selectedDoctor, setSelectedDoctor] = useState(null);

    const handleSelectDoctor = doctor => {
        setSelectedDoctor(doctor);
    };

    return (
        <div>
            <h1>List of Doctors</h1>
            <DoctorTable onSelectDoctor={handleSelectDoctor} />
            {selectedDoctor && <DoctorDetails doctor={selectedDoctor} />}
        </div>
    );
};

export default App;
