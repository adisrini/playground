import React from "react";
import InboxPane from "./InboxPane"
import ConversationPane from "./ConversationPane"
import StorePane from "./StorePane"

var sample = require('../../data/sample-data');

export default class Layout extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      "humans": {},
      "stores": {}
    }
  }

  loadSampleData() {
    this.setState(sample);
  }

  render() {
    return (
      <div>
        <div id="header"></div>
        <button onClick={this.loadSampleData.bind(this)}>Load Sample Data</button>
        <div className="container">
          <div className="column">
            <InboxPane humans={this.state.humans} />
          </div>
          <div className="column">
            {this.props.children || "Select a Conversation from the Inbox"}
          </div>
          <div className="column">
            <StorePane stores= {this.state.stores} />
          </div>
        </div>
      </div>
    );
  }
}
