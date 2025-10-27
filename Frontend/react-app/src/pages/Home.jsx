import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom'

// eslint-disable-next-line import/no-anonymous-default-export
export default function
  () {


  const [users, setUsers] = useState([])

  useEffect(() => {
    loadUsers();
  }, [])

  const { id } = useParams();

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/users")
    setUsers(result.data);
  }

  const deleteUser = async (id) => {
    await axios.delete(`http://localhost:8080/user/${id}`);
    loadUsers();
  }

  return (
    <div className='container border shadow'>
      <div className='py-4'>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">UserName</th>
              <th scope="col">Name</th>
              <th scope="col">Email</th>
              <th scope="col">Action</th>

            </tr>
          </thead>
          <tbody>
            {
              users.map((user) => (
                <tr key={user.id}>
                  <th scope="row">{user.id}</th>
                  <td>{user.username}</td>
                  <td>{user.name}</td>
                  <td>{user.email}</td>
                  <td>
                    <Link className='btn btn-primary mx-2' to={`/viewuser/${user.id}`}>
                      View
                    </Link>                    <Link className='btn btn-outline-primary mx-2' to={`/user/${user.id}`}>Edit</Link>
                    <button className='btn btn-danger mx-2'
                      onClick={() => deleteUser(user.id)}
                    >Delete</button>
                  </td>

                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}
