import React from "react"

export default class Store extends React.Component {
  getCount(status) {
    return this.props.details.orders.filter(function(n) {return n.status === status}).length;
  }

  render() {
    return(
      <li>
        <p>{this.props.index}</p>
        <p>Orders Confirmed: {this.getCount("Confirmed")}</p>
        <p>Orders In The Oven: {this.getCount("In The Oven")}</p>
        <p>Orders Delivered: {this.getCount("Delivered")}</p>
      </li>
    )
  }
}
