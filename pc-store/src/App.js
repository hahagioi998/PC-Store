import "./App.css";
import NavBar from "./components/NavBar";
import About from "./pages/About";
import Home from "./pages/Home";
import { Route, Switch } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <NavBar />
      <Switch>
        <Route exact path="/About">
          <About />
        </Route>
        <Route exact path="/*">
          <Home />
        </Route>
      </Switch>
    </div>
  );
}

export default App;
