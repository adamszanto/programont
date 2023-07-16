import React from 'react';
import { Route, Routes } from 'react-router-dom';
import DoctorList from './DoctorList';
import Doctor from './Doctor';

const App = () => {
    return (
        <Routes>
            <Route path="/" element={<DoctorList />} />
            <Route path="/doctor/:id" element={<Doctor />} />
        </Routes>
    );
};

export default App;
