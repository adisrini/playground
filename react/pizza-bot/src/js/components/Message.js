import React from "react"

export default class Message extends React.Component {
  render() {
    return(
      <p>{this.props.who} said: "{this.props.text}"</p>
    )
  }
}
