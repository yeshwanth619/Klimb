
import './App.css';

import DashboardPage from './layout/DashboardPage/DashboardPage';

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
function App() {

  return (
    <div className="App">
      <Router>
  
      <Routes>
        <Route path="/" element={<DashboardPage />} />
        
        
      </Routes>
    </Router>
  
    </div>
  );
}

export default App;
