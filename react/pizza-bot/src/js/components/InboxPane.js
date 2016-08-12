import React from "react"
import InboxItem from "./InboxItem";

export default class InboxPane extends React.Component {

  renderInboxItem(human) {
    return <InboxItem key={human} index={human} details={this.props.humans[human]} />
  }

  render() {
    return(
      <div id="inbox-pane">
        <h1>Inbox</h1>
        <table>
          <thead>
            <tr>
              <th>Chat Received</th>
              <th>Name</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {Object.keys(this.props.humans).map(this.renderInboxItem.bind(this))}
          </tbody>
        </table>
      </div>
    )
  }

}
