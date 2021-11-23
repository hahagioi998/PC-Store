import React, { Component } from "react";

class ProductDetails extends Component {
  constructor(props) {
    super(props);
    this.state = {
      product: {},
    };
  }

  componentDidMount() {
    fetch(
      "http://192.168.1.149:8080/api/products/" + this.props.match.params.id
    )
      .then((data) => data.json())
      .then((json) => {
        this.setState({
          product: json,
        });
        this.setState({
          product: {
            ...this.state.product,
            image: "data:image/png;base64," + this.state.product.image,
          },
        });
      })
      .catch(function (ex) {
        console.log("Error:", ex);
      });
  }

  renderProductPage() {
    return (
      <React.Fragment>
        <h1>{this.state.product.name}</h1>
        <h3>{this.state.product.description}</h3>
        <img src={this.state.product.image} alt="" />
      </React.Fragment>
    );
  }

  render() {
    //const name = this.props.match.params.name;

    return <div className="border">{this.renderProductPage()}</div>;
  }
}

export default ProductDetails;
