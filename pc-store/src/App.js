import "./App.css";
import NavBar from "./components/NavBar";
import About from "./pages/About";
import Home from "./pages/Home";
import { Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <NavBar />
      <Route exact path="/*" component={Home} />
      <Route exact path="/About" component={About} />
    </div>
  );
}

export default App;
