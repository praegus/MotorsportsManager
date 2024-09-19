import Link from 'next/link'

type Props = {
  data: string|undefined|null
}

// https://heroicons.com/
export default function NavBar({data}: Props) {
  
  return (
    <div className="w-full flex">
      <div className="flex-1">
        <Link href="/">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="size-8 ml-10 mt-2 text-gray-500">
                <path strokeLinecap="round" strokeLinejoin="round" d="m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
            </svg>
        </Link>
      </div>

      <div className="flex-1 w-9/10">
        &nbsp;
      </div>
      <div className="flex-none w-32">
        { data? 
        <p>Welcome! {data}</p>
        : ''}
      </div>
    </div>
  );
};
