import Link from 'next/link'

export default function NotFound() {
  return (
    <div className="w-full flex">
      <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
        <h1>Hey, wat doe je hier??? Ga eens even heeeel snel terug!</h1>
        <Link href="/"><button>Ok...</button></Link>
      </div>
    </div>
  );
};
