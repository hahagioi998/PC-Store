import React, { Component } from "react";
import ProductCard from "../components/ProductCard";

//import "../components/shared.css";
import "./Featured.css";

class Featured extends Component {
  constructor(props) {
    super(props);
    this.state = {
      featuredItems: [],
    };
  }

  componentDidMount() {
    fetch("http://192.168.1.149:8080/api/products/featured")
      .then((data) => data.json())
      .then((json) => {
        this.setState({
          featuredItems: json,
        });
      })
      .catch(function (ex) {
        console.log("Error:", ex);
      });
  }

  render() {
    const featuredProducts = this.state.featuredItems
      .filter((l) => l.featured === true)
      .map((l, i) => {
        return <ProductCard key={i} product={l} />;
      });

    return <div className="row">{featuredProducts}</div>;
  }
}

export default Featured;
