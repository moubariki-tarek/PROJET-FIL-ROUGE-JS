import logo from './logo.svg';
import './App.css';
import HomeScreen from './screens/homeScreen';
import DashboardScreen from './screens/dashboardScreen';
import { 
  BrowserRouter
} from 'react-router-dom';
import ScreenRoutes from './app/screensRoutes';

function App() {
  return (
    <BrowserRouter basename="/">
        <ScreenRoutes />
    </BrowserRouter>
  );
}

export default App;
