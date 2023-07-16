import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import DoctorList from './DoctorList';
import DoctorDetails from './DoctorDetails';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<DoctorList />} />
                <Route path="/doctor/:id" element={<DoctorDetails />} />
            </Routes>
        </Router>
    );
};

export default App;
