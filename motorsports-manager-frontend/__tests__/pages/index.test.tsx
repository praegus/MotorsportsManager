import { expect, test } from 'vitest'
import { render, screen } from '@testing-library/react'
import Home from '../../src/pages/index'
import { vi } from "vitest";

const mockPush = vi.fn();

vi.mock("next/router", () => {
  return {
    useRouter: () => ({
      push: mockPush,
      query: {}
    }),
  };
});

test('Profile page', () => {
  render(<Home />)
  expect(screen.getByText('Profile')).toBeTruthy()
})