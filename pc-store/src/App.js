import "./App.css";
import NavBar from "./components/NavBar";
import About from "./pages/About";
import Home from "./pages/Home";
import { Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <NavBar />
      <Routes>
        <Route exact path="/About" element={<About />}></Route>
        <Route exact path="/*" element={<Home />}></Route>
      </Routes>
    </div>
  );
}

export default App;
