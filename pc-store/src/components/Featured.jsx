import React, { Component } from "react";
import { products } from "../DummyData/categories.js";
import Product from "../components/Product";

class Featured extends Component {
  render() {
    const featuredProducts = products
      .filter((l) => l.isFeatured === true)
      .map((l, i) => {
        return (
          <span key={i}>
            <Product product={l} />
          </span>
        );
      });

    return <React.Fragment>{featuredProducts}</React.Fragment>;
  }
}

export default Featured;
