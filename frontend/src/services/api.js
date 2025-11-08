import axios from 'axios';
const BASE = 'http://localhost:8080/BankManagementSystem/api';
export const getAccounts = () => axios.get(BASE + '/accounts');
export const createAccount = (payload) => axios.post(BASE + '/accounts', payload);
export default { getAccounts, createAccount };