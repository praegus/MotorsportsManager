import {FormEvent} from 'react'

export default function Start() {
  async function onSubmit(event: FormEvent<HTMLFormElement>) {
      event.preventDefault();
      const formData = new FormData(event.currentTarget)

        console.log('test')
//       const response = await fetch('/api/submit', {
//         method: 'POST',
//         body: formData,
//       })
//
//         const data = await response.json()
  }

  return (
    <div className="w-full max-w-xs">
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" onSubmit={onSubmit}>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="profileName">
            Profile
          </label>
          <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="profileName" type="text" placeholder="ProfileName" />
        </div>
        <div className="flex items-center justify-between">
          <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
            Sign In
          </button>
        </div>
      </form>
    </div>
  );
};
