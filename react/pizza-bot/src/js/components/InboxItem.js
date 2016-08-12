import React from "react";
var ReactRouter = require('react-router');
var Link = ReactRouter.Link;

export default class InboxItem extends React.Component {

  sortByDate(a, b) {
    return a.time > b.time ? 1 : a.time < b.time ? -1 : 0;
  }

  messageSummary(conversations) {
    var lastMessage = conversations.sort(this.sortByDate)[conversations.length - 1];
    return lastMessage.who + ' said: "' + lastMessage.text + '" @ ' + lastMessage.time.toString()
  }

  render() {
    return(
      <tr>
        <td><Link to={'/conversation/' + encodeURIComponent(this.props.index)}>{this.messageSummary(this.props.details.conversations)}</Link></td>
        <td>{this.props.index}</td>
        <td>{this.props.details.orders.sort(this.sortByDate)[0].status}</td>
      </tr>
    )
  }
}
