import React from 'react';
import { slide as Menu } from 'react-burger-menu';
import './Sidebar.css';

export default props => {
  return (
    <Menu>
      <a className="menu-item" href="/">
        Home
      </a>
      <a className="menu-item" href="/addaccount">
        Add Account
      </a>
      <a className="menu-item" href="/accounts">
        Accounts
      </a>
    </Menu>
  );
};