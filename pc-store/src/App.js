import "./App.css";
import NavBar from "./shared/NavBar";
import Home from "./Home/Home";
import About from "./About/About";
import { Route, Link } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <NavBar />
      <Route exact path="/" component={Home} />
      <Route exact path="/About" component={About} />
    </div>
  );
}

export default App;
