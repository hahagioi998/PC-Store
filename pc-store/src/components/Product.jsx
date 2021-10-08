import React, { Component } from "react";

import { Card } from "react-bootstrap";

class Product extends Component {
  render() {
    return (
      <React.Fragment>
        <Card
          style={{
            width: "23%",
            display: "inline-block",
            margin: "0px 5px",
          }}
        >
          <Card.Body>
            <Card.Title>{this.props.product.name}</Card.Title>
            <Card.Text>{this.props.product.description}</Card.Text>
          </Card.Body>
        </Card>
      </React.Fragment>
    );
  }
}

export default Product;
