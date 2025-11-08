import React, {useEffect, useState} from 'react';
import axios from 'axios';

export default function Dashboard() {
  const [accounts, setAccounts] = useState([]);

  useEffect(()=>{
    axios.get('/BankManagementSystem/api/accounts')
      .then(res=> setAccounts(res.data))
      .catch(()=> {});
  },[]);

  return (
    <div>
      <h3>Accounts</h3>
      <ul>
        {accounts && accounts.map(a=> <li key={a.accountId}>{a.accountId} - {a.accountType} - {a.balance}</li>)}
      </ul>
    </div>
  );
}
