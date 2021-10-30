import React, { Component } from "react";
import ProductCard from "../components/ProductCard";

class SearchResults extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
    };
  }

  componentDidMount() {
    fetch(
      "http://192.168.1.149:8080/api/products/search?params=" +
        this.props.match.params.params
    )
      .then((data) => data.json())
      .then((json) => {
        this.setState({
          products: json,
        });
      })
      .catch(function (ex) {
        console.log("Error:", ex);
      });
  }

  renderProductsFromSearch() {
    return this.state.products.map((prod, i) => {
      return <ProductCard key={i} product={prod} />;
    });
  }

  render() {
    return <div className="row">{this.renderProductsFromSearch()}</div>;
  }
}

export default SearchResults;
