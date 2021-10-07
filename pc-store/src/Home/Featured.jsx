import React, { Component } from "react";
import { categories } from "../DummyData/categories.js";
import Product from "../shared/Product";

class Featured extends Component {
  render() {
    const featuredProducts = categories
      .filter((l) => l.isFeatured === true)
      .map((l) => {
        return <Product key={l.id} product={l} />;
      });

    return <React.Fragment>{featuredProducts}</React.Fragment>;
  }
}

export default Featured;
