import React from "react"
import Message from "./Message"

var sample = require('../../data/sample-data.js')

export default class ConversationPane extends React.Component {

  constructor(props) {
    super(props);
    this.loadConversationData(this.props.params.human);
    this.state = {
      "mounted": true
    }
  }

  componentWillUnmount() {
    this.state.mounted = false;
  }

  componentWillReceiveProps(newProps) {
    this.loadConversationData.(newProps.params.human);
  }

  loadConversationData(human) {
    if(this.state.mounted) {
      this.setState({conversation: sample.humans[human].conversations});
    }
  }

  renderMessage(human) {
    return <Message who={human.who} text={human.text} key={human.time.getTime()} />
  }

  render() {
    return (
      <div id="conversation-pane">
      <h1>Conversation</h1>
      <h3>{this.props.params.human}</h3>
      <div id="messages">
        {this.state.conversation.map(this.renderMessage)}
      </div>
      </div>
    )
  }
}
