import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_AUTH;

const AuthService = {

  register(user) {
    return axios.post(`${API_BASE_URL}/register`, user);
  },

  login(credentials) {
    return axios.post(`${API_BASE_URL}/login`, credentials);
  },

};

export default AuthService;
