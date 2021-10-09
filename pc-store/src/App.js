import "./App.css";
import NavBar from "./components/NavBar";
import Home from "./pages/Home";
import About from "./pages/About";
import Category from "./pages/Category";
import ProductDetails from "./pages/ProductDetails";
import { Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <NavBar />
      <Route exact path="/" component={Home} />
      <Route exact path="/category/:name" component={Category} />
      <Route exact path="/product-details/:name" component={ProductDetails} />
      <Route exact path="/About" component={About} />
    </div>
  );
}

export default App;
