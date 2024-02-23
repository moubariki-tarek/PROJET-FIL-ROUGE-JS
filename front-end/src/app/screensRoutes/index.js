import { Route, Routes } from "react-router-dom";
import HomeScreen from "../../screens/homeScreen";
import DashboardScreen from "../../screens/dashboardScreen";

const ScreenRoutes = () => {
    return(
        <Routes>
            <Route path="/" index element={<HomeScreen />} />
            <Route path="/dashboard" element={<DashboardScreen />} />
        </Routes>
    );
};

export default ScreenRoutes;