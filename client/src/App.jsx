import { Route, Routes, Navigate } from "react-router-dom";
import ProtectedRoute from "./services/ProtectedRoute";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import AppoinmentsPage from "./pages/AppoinmentsPage";
import DoctorsPage from "./pages/DoctorsPage";
import PatientsPage from "./pages/PatientsPage";
import DoctorPage from "./pages/doctors/[...id]";
import AppoinmentPage from "./pages/appointments/[...id]";
import PatientPage from "./pages/patients/[...id]";

function App() {

  const token = localStorage.getItem("token"); 

  return (
    <>
      <main className="w-full min-h-screen bg-[#f3f4f6] ">
        <Routes>
          <Route path="/" element={<Navigate to="/login" replace />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Register />} />

          <Route path="/dashboard" element={ <ProtectedRoute token={token}><Dashboard /></ProtectedRoute>}/>
          <Route path="/appointments"element={<ProtectedRoute token={token}><AppoinmentsPage /></ProtectedRoute>}/>
          <Route path="/appointments/:id" element={ <ProtectedRoute token={token}><AppoinmentPage /></ProtectedRoute>}/>
          <Route path="/doctors" element={<ProtectedRoute token={token}><DoctorsPage /></ProtectedRoute>}/>
          <Route path="/doctors/:id"element={<ProtectedRoute token={token}><DoctorPage /></ProtectedRoute>}/>
          <Route path="/patients" element={<ProtectedRoute token={token}><PatientsPage /></ProtectedRoute>} />
          <Route path="/patients/:id"element={<ProtectedRoute token={token}><PatientPage /></ProtectedRoute>}/>

        </Routes>
      </main>
    </>
  );
}

export default App;
